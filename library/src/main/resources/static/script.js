async function fetchBooks() {
    try {
        const response = await fetch('http://localhost:8080/Books');
        if (response.ok) {
            const books = await response.json();
            displayBooks(books);
        } else {
            console.error('Erro ao buscar livros:', response.status);
        }
    } catch (error) {
        console.error('Erro de conexão:', error);
    }
}


function displayBooks(books) {
    const bookList = document.getElementById('bookList');
    bookList.innerHTML = '';
    books.forEach(book => {
        const li = document.createElement('li');
        li.textContent = `${book.name}`;

        const buttonContainer = document.createElement('div');
        buttonContainer.style.display = 'inline-block';
        buttonContainer.style.marginLeft = '10px';

        const updateButton = document.createElement('button');
        updateButton.textContent = 'Atualizar';
        updateButton.onclick = () => updateBook(book.id);
        buttonContainer.appendChild(updateButton);

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Deletar';
        deleteButton.onclick = () => deleteBook(book.id);
        buttonContainer.appendChild(deleteButton);

        li.appendChild(buttonContainer);
        bookList.appendChild(li);
    });
}

async function addBook(event) {
    event.preventDefault();

    const name = document.getElementById('title').value;
    const book = { name };

    try {
        const response = await fetch('http://localhost:8080/Books', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(book)
        });

        if (response.ok) {
            console.log('Livro adicionado com sucesso!');
            fetchBooks();
            document.getElementById('bookForm').reset();
        } else {
            console.error('Erro ao adicionar livro:', response.status);
        }
    } catch (error) {
        console.error('Erro de conexão:', error);
    }
}


async function deleteBook(id) {
    try {
        const response = await fetch(`http://localhost:8080/Books/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            console.log('Livro deletado com sucesso!');
            fetchBooks();
        } else {
            console.error('Erro ao deletar livro:', response.status);
        }
    } catch (error) {
        console.error('Erro de conexão:', error);
    }
}

async function updateBook(bookId) {
    const newTitle = prompt('Digite o novo título do livro:');
    if (newTitle) {
        const updatedBook = { name: newTitle };

        try {
            const response = await fetch(`http://localhost:8080/Books/${bookId}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(updatedBook)
            });

            if (response.ok) {
                console.log(`Livro com ID ${bookId} atualizado com sucesso!`);
                fetchBooks();
            } else {
                console.error('Erro ao atualizar livro:', response.status);
            }
        } catch (error) {
            console.error('Erro de conexão:', error);
        }
    }
}


document.getElementById('bookForm').addEventListener('submit', addBook);

window.onload = fetchBooks;
