import React from 'react'
import { GoogleMap, LoadScript, Marker } from '@react-google-maps/api';

const Map = (props) => (
        <div className={props.mini ? "google-map-mini" : "google-map" } >
        <LoadScript>
            <GoogleMap
                mapContainerStyle={{height: "100%", width: "100%"}}
                zoom={props.zoom}
                center={props.defaultCenter}>
                {
                    props.markers.map(item => {
                        return (
                        <Marker key={item.name} position={item.location}/>
                        )
                      })
                }
            </GoogleMap>
        </LoadScript>
        </div>
)

export default Map;