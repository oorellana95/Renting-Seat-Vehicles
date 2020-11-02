import React from 'react'

function CategoryList(props) {
    const [val, setValue] = React.useState(0)

    return (
        <>
            <div className="blog_right_sidebar">
                <aside className="single_sidebar_widget post_category_widget">
                    <h4 className="widget_title">Category</h4>
                    <ul className="list cat-list">
                        {props.itemAll && (
                            <li key="0">
                                <a className = "d-flex" onClick={() => {setValue(0); props.filterFunction(0)}}>
                                    <p className = {(val==0 ? 'active' : '')}>All categories</p>
                                </a>
                            </li>
                        )}
                        {props.items.map(item => {
                            console.log(item.id);
                            return (
                                <li key={item.id}>
                                    <a className = "d-flex" onClick={() => {setValue(item.id); props.filterFunction(item.id)}}>
                                        <p className = {(val==item.id ? 'active' : '')}>{item.name}</p>
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