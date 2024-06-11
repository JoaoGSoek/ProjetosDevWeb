import React, { useMemo, useState } from 'react'
import ArtigoDataService from "../services/artigoDataService";
import { useNavigate, useParams } from 'react-router-dom';

const ArticleAdd = () => {

    const navigate = useNavigate();

    const {id} = useParams();

    const [title, setTitle] = useState("");
    const [excerpt, setExcerpt] = useState("");
    const [published, setPublished] = useState(false);

    useMemo(() => {
        if(id){

            ArtigoDataService.get(id).then(({data: artigo}) => {

                setTitle(artigo.titulo);
                setExcerpt(artigo.resumo);
                setPublished(artigo.publicado);

            }).catch(() => {

                alert("Algo deu errado ao carregar o artigo.");

            });

        }
    }, [id, setTitle, setExcerpt, setPublished]);

    const send = (e) => {

        e.preventDefault();

        if(id){

            ArtigoDataService.update(id, {
                titulo: title,
                resumo: excerpt,
                publicado: published
            }).then(() => {
                
                alert("Artigo atualizado com sucesso!");
                navigate("/");
            
            }).catch(() => {

                alert("Algo deu errado ao atualizar o artigo.");

            });

        }else{

            ArtigoDataService.create({
                titulo: title,
                resumo: excerpt,
                publicado: published
            }).then(() => {
                
                alert("Artigo cadastrado com sucesso!");
                navigate("/");
            
            }).catch(() => {

                alert("Algo deu errado ao cadastrar o artigo.");

            });
        
        }

    }

    return (

        <form id="articleAdd" className="column" onSubmit={e => send(e)}>

            <div className="column">

                <h3>Novo Artigo</h3>
                <input type="text" placeholder="Título" value={title} onChange={e => setTitle(e.target.value)}/>
                <textarea placeholder="Resumo" value={excerpt} onChange={e => setExcerpt(e.target.value)}></textarea>
                <div className="row actions">

                    {/*<label className="row">

                        <input type="checkbox" defaultChecked={published} onChange={e => setPublished(e.target.checked)} />
                        <p>Publicado</p>

                    </label>*/}
                    <button className="btn success">{id ? "Atualizar" : "Cadastrar"}</button>

                </div>

            </div>

        </form>

    )

}

export default ArticleAdd