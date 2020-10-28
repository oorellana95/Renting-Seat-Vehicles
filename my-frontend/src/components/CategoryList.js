import React from 'react'

function CategoryList(props) {
    return (
        <>
            <div className="blog_right_sidebar">
                <aside className="single_sidebar_widget post_category_widget">
                    <h4 className="widget_title">Category</h4>
                    <ul className="list cat-list">
                        {props.items.map(item => {
                            return (
                                <li key={item.id}>
                                    <a href="#" className="d-flex">
                                        <p>{item.name}</p>
                                    </a>
                                </li>
                            )
                        })}
                    </ul>
                </aside>
            </div>
        </>
    );
}

export default CategoryList;