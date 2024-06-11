import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import ArticleAdd from './components/articleAdd';
import ArticleList from './components/articleList';

function App() {

	return (

		<BrowserRouter>

			<div id="app" className="grid">

				<header id="mainHeader">

					<div className="content row">

						<h1><Link to={"/"}>Projeto 03</Link></h1>
						<Link className="btn success" to={"/new"}>Cadastrar artigo</Link>

					</div>

				</header>
				<main>

					<Routes>

						<Route element={<ArticleList/>} path={"/"}></Route>
						<Route element={<ArticleAdd/>} path={"/new"}></Route>
						<Route element={<ArticleAdd/>} path={"/edit/:id"}></Route>

					</Routes>

				</main>

			</div>

		</BrowserRouter>

	);
}

export default App;
