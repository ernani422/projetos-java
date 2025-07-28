import React, { useState, useEffect } from 'react';

function App() {
  const [livros, setLivros] = useState([]);
  const [form, setForm] = useState({
    titulo: '',
    isbn: '',
    preco: '',
    genero: 'FICCAO',
    autorNome: '',
    autorNacionalidade: '',
    autorDataNascimento: ''
  });
  const [loading, setLoading] = useState(false);
  const [mensagem, setMensagem] = useState('');

  useEffect(() => {
    buscarLivros();
  }, []);

  const buscarLivros = async () => {
    setLoading(true);
    try {
      const res = await fetch('http://localhost:8080/livros');
      const data = await res.json();
      setLivros(data);
    } catch {
      setMensagem('Erro ao buscar livros');
    }
    setLoading(false);
  };

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async e => {
    e.preventDefault();
    if (!form.titulo || !form.isbn || !form.preco || !form.autorNome) {
      setMensagem('Preencha todos os campos obrigatórios!');
      return;
    }
    setLoading(true);
    setMensagem('');
    const livro = {
      titulo: form.titulo,
      isbn: form.isbn,
      preco: form.preco,
      genero: form.genero,
      autor: {
        nome: form.autorNome,
        nacionalidade: form.autorNacionalidade,
        dataNascimento: form.autorDataNascimento
      }
    };
    try {
      const res = await fetch('http://localhost:8080/livros', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(livro)
      });
      if (res.ok) {
        setMensagem('Livro cadastrado com sucesso!');
        setForm({
          titulo: '',
          isbn: '',
          preco: '',
          genero: 'FICCAO',
          autorNome: '',
          autorNacionalidade: '',
          autorDataNascimento: ''
        });
        buscarLivros();
      } else {
        setMensagem('Erro ao cadastrar livro');
      }
    } catch {
      setMensagem('Erro de conexão');
    }
    setLoading(false);
  };

  return (
    <div style={{
      maxWidth: 600,
      margin: '40px auto',
      padding: 24,
      background: '#f9f9f9',
      borderRadius: 8,
      boxShadow: '0 2px 8px #ccc'
    }}>
      <h2 style={{ textAlign: 'center' }}>Cadastro de Livro</h2>
      <form onSubmit={handleSubmit} style={{ marginBottom: 32 }}>
        <label>Título*:<br />
          <input name="titulo" value={form.titulo} onChange={handleChange} required />
        </label><br /><br />
        <label>ISBN*:<br />
          <input name="isbn" value={form.isbn} onChange={handleChange} required />
        </label><br /><br />
        <label>Preço*:<br />
          <input name="preco" type="number" value={form.preco} onChange={handleChange} required />
        </label><br /><br />
        <label>Gênero:<br />
          <select name="genero" value={form.genero} onChange={handleChange}>
            <option value="FICCAO">Ficção</option>
            <option value="FANTASIA">Fantasia</option>
            <option value="MISTERIO">Mistério</option>
            <option value="ROMANCE">Romance</option>
            <option value="BIOGRAFIA">Biografia</option>
            <option value="CIENCIA">Ciência</option>
          </select>
        </label><br /><br />
        <label>Nome do Autor*:<br />
          <input name="autorNome" value={form.autorNome} onChange={handleChange} required />
        </label><br /><br />
        <label>Nacionalidade do Autor:<br />
          <input name="autorNacionalidade" value={form.autorNacionalidade} onChange={handleChange} />
        </label><br /><br />
        <label>Data de Nascimento do Autor:<br />
          <input name="autorDataNascimento" type="date" value={form.autorDataNascimento} onChange={handleChange} />
        </label><br /><br />
        <button type="submit" disabled={loading} style={{
          background: '#1976d2',
          color: '#fff',
          border: 'none',
          padding: '8px 24px',
          borderRadius: 4,
          cursor: 'pointer'
        }}>
          {loading ? 'Salvando...' : 'Cadastrar'}
        </button>
      </form>
      {mensagem && <div style={{ color: mensagem.includes('sucesso') ? 'green' : 'red', marginBottom: 16 }}>{mensagem}</div>}
      <h2 style={{ textAlign: 'center' }}>Livros cadastrados</h2>
      {loading ? <div>Carregando...</div> : (
        <ul>
          {livros.map(livro => (
            <li key={livro.id} style={{ marginBottom: 12, padding: 8, background: '#fff', borderRadius: 4 }}>
              <strong>{livro.titulo}</strong> — ISBN: {livro.isbn} — {livro.genero} — R$ {livro.preco}<br />
              Autor: {livro.autor?.nome} ({livro.autor?.nacionalidade}) {livro.autor?.dataNascimento && `- Nasc.: ${livro.autor.dataNascimento}`}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default App;