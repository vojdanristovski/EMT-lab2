import axios from "../custom-axios/axios"

const BookService={

    fetchBooks:()=>{
        return axios.get("/books");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchAuthors: () =>{
      return axios.get("/authors")
    },
    getBook:(id)=>{
        return axios.get(`/books/${id}`)
    },
    addBook:(name,availableCopies,category,author) => {
      return axios.post("/books/add",{
          "name":name,
          "availableCopies":availableCopies,
          "category":category,
          "author":author
      });
    },
    deleteBook:(id)=>{
        return axios.delete(`/books/delete/${id}`);
    },
    editBook:(id,name,copies,category,author)=>{
        return axios.put(`/books/edit/${id}`,{
            "name":name,
            "availableCopies":copies,
            "category":category,
            "author":author
        })
    }



}
export default BookService;