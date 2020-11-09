import React from 'react'
import ModalVideo from 'react-modal-video'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faPlay } from '@fortawesome/free-solid-svg-icons'

function VideoModalSection(props) {
    const [isOpen, setOpen] = React.useState(false)

    return (
        <>
            <React.Fragment>
                <ModalVideo channel='youtube' autoplay isOpen={isOpen} videoId={props.videoId} onClose={() => setOpen(false)} />
                <div className="video_area overlay" style={{ backgroundImage: "url(" + props.videoImage + ")"}}>
                    <div className="video_area_inner text-center">
                        <span>{props.miniTitle}</span>
                        <h3>{props.title}</h3>
                        <a type="button" onClick={() => setOpen(true)} className="video_btn popup-video pl-1">
                            <FontAwesomeIcon icon={faPlay} color="black" />
                        </a>
                    </div>
                </div>
            </React.Fragment>
        </>
    );
}

export default VideoModalSection;