import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import React,{Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import BookService from "../../service/bookService";
import Categories from "../Categories/categories";
import Books from "../Book/BookList/books";
import BookAdd from "../Book/BookAdd/bookAdd";
import BookEdit from "../Book/BookEdit/bookEdit";

import Header from "../Header/header.js";
class App extends Component{
  constructor(props) {
    super(props);
    this.state={
      books:[],
      categories:[],
      authors:[],
      selectBook:{}
    }

  }

  render() {
    return (
        <Router>
          <Header/>
          <main>
              <div className={"container"}>
                  <Route path={"/categories"} exact render={()=>
                      <Categories categories={this.state.categories}/>}/>
                  <Route path={"/books/add"} exact render={()=>
                      <BookAdd categories={this.state.categories}
                               authors={this.state.authors}
                               onAddBook={this.addBook}/>}/>
                  <Route path={"/books/edit/:id"} exact render={()=>
                      <BookEdit categories={this.state.categories}
                                authors={this.state.authors}
                                book={this.state.selectedBook}
                                onEditBook={this.editBook}/>}/>
                  <Route path={"/books"} exact render={()=>
                      <Books books={this.state.books}
                             onDelete={this.deleteBook}
                             onEdit={this.getBook}/>}/>
              </div>
          </main>
        </Router>
    );
  }

  componentDidMount() {
      this.loadBooks();
      this.loadCategories();
      this.loadAuthors();
  }

  loadBooks=()=>{
    BookService.fetchBooks()
        .then((data)=>{
          this.setState({
            books: data.data
          })
        })
  }
  loadCategories=()=>{
    BookService.fetchCategories()
        .then((data)=>{
          this.setState({
            categories: data.data
          })
        })
  }
  loadAuthors=()=>{
      BookService.fetchAuthors()
          .then((data)=>{
              console.log(data.data);
              this.setState({

                  authors:data.data

              })
          })
  }

  getBook=(id)=>{
    BookService.getBook(id)
        .then((data)=>{
            this.setState({
                selectedBook:data.data
            })

        })
  }
  deleteBook=(id)=>{
     BookService.deleteBook(id)
         .then(()=>{
             this.loadBooks();
         })
  }
  addBook=(name,copies,category,author)=>{
     BookService.addBook(name,copies,category,author)
         .then(()=>{
             this.loadBooks();
         })
  }
  editBook=(id,name,copies,category,author)=>{
     BookService.editBook(id,name,copies,category,author)
         .then(()=>{
             this.loadBooks();
         })
  }

}

export default App;
