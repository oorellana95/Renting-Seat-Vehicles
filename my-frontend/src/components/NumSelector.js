import React from 'react'

function NumSelector(props) {
    const [val, setValue] = React.useState(1)
    return (
        <>
            <div className="blog_right_sidebar">
                <aside className="single_sidebar_widget post_category_widget">
                    <h4 className="widget_title">Min. Passengers</h4>
                    <nav className="pagination pagination-info" aria-label="pagination">
                        <ul className="pagination-info pagination">
                            {props.nums.map(num => {
                                return (
                                    <li key={num} id={"li"+num} className = {'page-item ' + (num < val ? '' : 'active')} onClick={() => {setValue(num); props.filterFunction(num)}}>
                                        <span className="page-link">{num}</span>
                                    </li>
                                )
                            })}
                        </ul>
                    </nav>
                </aside>
            </div>
        </>
    );
}

export default NumSelector;