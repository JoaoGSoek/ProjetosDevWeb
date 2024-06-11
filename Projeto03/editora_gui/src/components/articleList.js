import React, { useState } from 'react'
import ArtigoDataService from "../services/artigoDataService";
import { Link } from 'react-router-dom';

const ArticleList = () => {

    const [artigos, setArtigos] = useState([]);
    const [loading, setLoading] = useState(true);

    ArtigoDataService.getAll().then(response => {

        setLoading(false);
        setArtigos(response.data);

    });

    const deleteArticle = (e, id) => {

        e.preventDefault();
        if(window.confirm("Tem certeza que deseja deletar esse artigo?")) ArtigoDataService.delete(id);

    }

    return (

        <section id="main" className="column">

            {loading ? (

                <div id="loading">Carregando...</div>

            ) : (

                artigos.length === 0 ? (

                    <div>Não há artigos cadastrados</div>

                ) : (

                    <div className="content grid">

                        <h3>Artigos Cadastrados</h3>
                        {artigos.map((artigo, index) => (

                            <article className="column" key={index}>

                                <header className="row">

                                    <h5>{artigo.titulo}</h5>
                                    <Link to={`/edit/${artigo.id}`} className="material-symbols-outlined success">edit</Link>
                                    <button onClick={e => deleteArticle(e, artigo.id)} className="material-symbols-outlined error">delete</button>

                                </header>
                                <p>{artigo.resumo}</p>

                            </article>

                        ))}

                    </div>  

                )

            )}

        </section>

    )

}

export default ArticleList