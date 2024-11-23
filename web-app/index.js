let colaboradores = [];
let indiceEditando = null;

//exemplo
colaboradores = [
    {
        nome: "Mariana Oliveira",
        cpf: "137.249.548-81",
        contato: "(55) 555-0118",
        email: "mariana.oliveira@exemplo.com",
        habilidades: "Javascript e Java",
        experiencia: "2 anos"
    },
    {
        nome: "Felipe Bragança",
        cpf: "123.453.589-88",
        contato: "(55) 555-0100",
        email: "felipe.braganca@exemplo.com",
        habilidades: "Figma e HTML, CSS",
        experiencia: "5 anos"
    }
];

// Função para renderizar a tabela
function renderizarTabela() {
    const tbody = document.getElementById('tabelaCorpo');
    tbody.innerHTML = '';

    colaboradores.forEach((colaborador, indice) => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${colaborador.nome}</td>
            <td>${colaborador.cpf}</td>
            <td>${colaborador.contato}</td>
            <td>${colaborador.email}</td>
            <td>${colaborador.habilidades}</td>
            <td>${colaborador.experiencia}</td>
            <td class="acoes">
                <button class="botao-editar" onclick="editarColaborador(${indice})">✏</button>
                <button class="botao-excluir" onclick="excluirColaborador(${indice})">🗑</button>
            </td>
        `;
        tbody.appendChild(tr);
    });
}

// Funções do Modal
function abrirModal(indice = null) {
    const modal = document.getElementById('modal');
    const modalTitulo = document.getElementById('modalTitulo');
    const form = document.getElementById('formularioColaborador');

    indiceEditando = indice;

    if (indice !== null) {
        modalTitulo.textContent = 'Editar Colaborador';
        const colaborador = colaboradores[indice];
        form.nome.value = colaborador.nome;
        form.cpf.value = colaborador.cpf;
        form.contato.value = colaborador.contato;
        form.email.value = colaborador.email;
        form.habilidades.value = colaborador.habilidades;
        form.experiencia.value = colaborador.experiencia;
    } else {
        modalTitulo.textContent = 'Adicionar Colaborador';
        form.reset();
    }

    modal.style.display = 'block';
}

function fecharModal() {
    const modal = document.getElementById('modal');
    modal.style.display = 'none';
    indiceEditando = null;
}

function excluirColaborador(indice) {
    if (confirm('Tem certeza que deseja excluir este colaborador?')) {
        colaboradores.splice(indice, 1);
        renderizarTabela();
    }
}

function editarColaborador(indice) {
    abrirModal(indice);
}

document.getElementById('formularioColaborador').addEventListener('submit', function(e) {
    e.preventDefault();

    const colaborador = {
        nome: this.nome.value,
        cpf: this.cpf.value,
        contato: this.contato.value,
        email: this.email.value,
        habilidades: this.habilidades.value,
        experiencia: this.experiencia.value
    };

    if (indiceEditando !== null) {
        colaboradores[indiceEditando] = colaborador;
    } else {
        colaboradores.push(colaborador);
    }

    renderizarTabela();
    fecharModal();
});

// Função filtrar colaboradores na barra de busca
function filtrarColaboradores() {
    const termoBusca = document.querySelector('.search-bar__input').value.toLowerCase();
    const tbody = document.getElementById('tabelaCorpo');

    tbody.innerHTML = ''; // Limpar a tabela

    colaboradores
        .filter(colaborador =>
            colaborador.nome.toLowerCase().includes(termoBusca) ||
            colaborador.email.toLowerCase().includes(termoBusca) ||
            colaborador.habilidades.toLowerCase().includes(termoBusca))
        .forEach((colaborador, indice) => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${colaborador.nome}</td>
                <td>${colaborador.cpf}</td>
                <td>${colaborador.contato}</td>
                <td>${colaborador.email}</td>
                <td>${colaborador.habilidades}</td>
                <td>${colaborador.experiencia}</td>
                <td class="acoes">
                    <button class="botao-editar" onclick="editarColaborador(${indice})">✏</button>
                    <button class="botao-excluir" onclick="excluirColaborador(${indice})">🗑</button>
                </td>
            `;
            tbody.appendChild(tr);
        });
}

document.querySelector('.search-bar__input').addEventListener('input', filtrarColaboradores);

renderizarTabela();