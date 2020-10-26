import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faUser } from '@fortawesome/free-solid-svg-icons'

function VehicleCard(props) {
    return (
        <>
            <article class="vehicle_item">
                <div class="vehicle_item_img">
                    <img class="card-img rounded-0" src= {require("assets/img/vehicles-for-rent/seat-ibiza.jpg")} alt=""></img>
                    <a href="#" class="vehicle_item_date">
                        <FontAwesomeIcon icon={faUser} color="white" size="2x" />
                    </a>
                </div>

                <div class="vehicle_details">
                    <h2>Google inks pact for new 35-storey office</h2>
                    <p>That dominion stars lights dominion divide years for fourth have don't stars is that
                                    he earth it first without heaven in place seed it second morning saying.</p>
                    <ul class="vehicle-info-link">
                        <li><FontAwesomeIcon icon={faUser} color="#2977c9" size="1x" className="mr-2" /><a href="#">Travel, Lifestyle</a></li>
                        <li><FontAwesomeIcon icon={faUser} color="#2977c9" size="1x" className="mr-2" /><a href="#">03 Comments</a></li>
                    </ul>
                </div>
            </article>
        </>
    );
}

export default VehicleCard;