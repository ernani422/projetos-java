import React, { useState, useEffect } from 'react';

function App() {
  const [livros, setLivros] = useState([]);
  const [titulo, setTitulo] = useState('');
  const [isbn, setIsbn] = useState('');
  const [preco, setPreco] = useState('');
  const [genero, setGenero] = useState('FICCAO');
  const [autorNome, setAutorNome] = useState('');
  const [autorNacionalidade, setAutorNacionalidade] = useState('');
  const [autorDataNascimento, setAutorDataNascimento] = useState('');

  useEffect(() => {
    fetch('http://localhost:8080/livros')
      .then(res => res.json())
      .then(data => setLivros(data));
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const livro = {
      titulo,
      isbn,
      preco,
      genero,
      autor: {
        nome: autorNome,
        nacionalidade: autorNacionalidade,
        dataNascimento: autorDataNascimento
      }
    };
    await fetch('http://localhost:8080/livros', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(livro)
    });
    window.location.reload();
  };

  return (
    <div style={{ padding: 32 }}>
      <h2>Cadastro de Livro</h2>
      <form onSubmit={handleSubmit}>
        <input placeholder="Título" value={titulo} onChange={e => setTitulo(e.target.value)} /><br />
        <input placeholder="ISBN" value={isbn} onChange={e => setIsbn(e.target.value)} /><br />
        <input placeholder="Preço" value={preco} onChange={e => setPreco(e.target.value)} /><br />
        <select value={genero} onChange={e => setGenero(e.target.value)}>
          <option value="FICCAO">Ficção</option>
          <option value="FANTASIA">Fantasia</option>
          <option value="MISTERIO">Mistério</option>
          <option value="ROMANCE">Romance</option>
          <option value="BIOGRAFIA">Biografia</option>
          <option value="CIENCIA">Ciência</option>
        </select><br />
        <input placeholder="Nome do Autor" value={autorNome} onChange={e => setAutorNome(e.target.value)} /><br />
        <input placeholder="Nacionalidade do Autor" value={autorNacionalidade} onChange={e => setAutorNacionalidade(e.target.value)} /><br />
        <input type="date" placeholder="Data de Nascimento do Autor" value={autorDataNascimento} onChange={e => setAutorDataNascimento(e.target.value)} /><br />
        <button type="submit">Cadastrar</button>
      </form>
      <h2>Livros cadastrados</h2>
      <ul>
        {livros.map(livro => (
          <li key={livro.id}>
            {livro.titulo} - {livro.isbn} - {livro.genero} - R$ {livro.preco} <br />
            Autor: {livro.autor?.nome} ({livro.autor?.nacionalidade})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;