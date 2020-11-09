import React from "react";

// reactstrap components
import {
    Carousel,
    CarouselItem,
    CarouselIndicators
} from "reactstrap";

function CarouselSection(props) {
    const [activeIndex, setActiveIndex] = React.useState(0);
    const [animating, setAnimating] = React.useState(false);
    const onExiting = () => {
        setAnimating(true);
    };
    const onExited = () => {
        setAnimating(false);
    };
    const next = () => {
        if (animating) return;
        const nextIndex = activeIndex === props.items.length - 1 ? 0 : activeIndex + 1;
        setActiveIndex(nextIndex);
    };
    const previous = () => {
        if (animating) return;
        const nextIndex = activeIndex === 0 ? props.items.length - 1 : activeIndex - 1;
        setActiveIndex(nextIndex);
    };
    const goToIndex = (newIndex) => {
        if (animating) return;
        setActiveIndex(newIndex);
    };
    return (
        <>
            <Carousel
                activeIndex={activeIndex}
                next={next}
                previous={previous}
            >
                <CarouselIndicators
                    items={props.items}
                    activeIndex={activeIndex}
                    onClickHandler={goToIndex}
                />
                {props.items.map((item) => {
                    return (
                        <CarouselItem
                            onExiting={onExiting}
                            onExited={onExited}
                            key={item.src}
                        >
                            <img className="d-block w-100" src={item.src} alt={item.altText}></img>
                            <div className="carousel-caption d-none d-md-block">
                                <h5>{item.caption}</h5>
                            </div>
                        </CarouselItem>
                    );
                })}
                <span
                    className="carousel-control-prev"
                    data-slide="prev"
                    href=""
                    onClick={(e) => {
                        e.preventDefault();
                        previous();
                    }}
                    role="button"
                >
                </span>
                <span
                    className="carousel-control-next"
                    data-slide="next"
                    href=""
                    onClick={(e) => {
                        e.preventDefault();
                        next();
                    }}
                    role="button"
                >
                </span>
            </Carousel>

        </>
    );
}

export default CarouselSection;
