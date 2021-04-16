import {useHistory} from 'react-router-dom';
import React from "react";

const BookEdit = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name:"",
        category:"",
        author: 0,
        copies:0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.book.name;
        const category = formData.category !== "" ? formData.category : props.book.category.toString();
        const author = formData.author !== 0 ? formData.author : props.book.author.id;
        const copies = formData.copies !== 0 ? formData.copies : props.book.availableCopies;


        props.onEditBook(props.book.id, name, copies, category, author);
        history.push("/books");
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.book?.name}
                               onChange={handleChange}
                        />
                    </div>


                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term,index) => {
                                return <option key={index} value={term.toString()}>{term.toString()}</option>
                            })}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term,index) => {
                                return <option key={index} value={term.id}>{term.name + " " + term.surname}</option>
                            })}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="availableCopies">Number Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="copies"
                               name="copies"
                               placeholder={props.book?.availableCopies}
                               onChange={handleChange}

                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default BookEdit;