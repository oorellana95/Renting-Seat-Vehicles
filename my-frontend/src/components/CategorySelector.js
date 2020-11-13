import React from 'react'

function CategorySelector(props) {
    const [val, setValue] = React.useState(0)

    return (
        <>
            <div className="blog_right_sidebar">
                <aside className="single_sidebar_widget post_category_widget">
                    <h4 className="widget_title">Category</h4>
                    <ul className="list cat-list">
                        {props.itemAll && (
                            <li key="0" id="li0" className="d-flex" onClick={() => { setValue(0); props.filterFunction(0) }}>
                                <p className={(val === 0 ? 'active' : '')}>All categories</p>
                            </li>
                        )}
                        {(props.items || !props.itemAll) && props.items.map(item => {
                            return (
                                <li className="d-flex" type="button" key={item.id} id={"li" + item.id} onClick={() => { setValue(item.id); props.filterFunction(item.id) }}>
                                    <p className={(val === item.id ? 'active' : '')}>{item.name}</p>
                                </li>
                            )
                        })}
                    </ul>
                    {props.error && <p>{props.error}</p>}
                </aside>
            </div>
        </>
    );
}

export default CategorySelector;