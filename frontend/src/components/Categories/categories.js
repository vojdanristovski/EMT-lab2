import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
const Categories=(props)=>{

    return(
        <div className={"container mm-4 mt-5"}>
          <div className={"row"}>
              <div className={"table-responsive"}>
                  <table className={"table table-striped"}>
                      <thead>
                        <th scope={"col"}>
                          Category
                        </th>
                      </thead>
                      <tbody>
                      {props.categories.map((category)=>{
                          return (
                              <tr>
                                  <td>{category.toString()}</td>
                              </tr>
                          );
                      })}
                      </tbody>
                  </table>
              </div>
          </div>
        </div>
    )

}
export default Categories;