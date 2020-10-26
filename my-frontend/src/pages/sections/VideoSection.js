import React from 'react'
import Iframe from 'react-iframe'

function VideoSection(props) {

    return (
        <>
            <div style={{backgroundColor : props.backgroundColor}}>
                <Iframe
                    src={props.urlVideo}
                    width="100%"
                    height="800"
                    frameBorder="0"
                    marginHeight="0"
                    marginWidth="0"
                />
            </div>
        </>
    );
}

export default VideoSection;