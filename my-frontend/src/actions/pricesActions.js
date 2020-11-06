import * as config from '../config.json';

export const GET_FINAL_PRICE_AND_OFFERS_SUCCESS = "GET_FINAL_PRICE_AND_OFFERS_SUCCESS";
export const GET_FINAL_PRICE_AND_OFFERS_FAILURE = "GET_FINAL_PRICE_AND_OFFERS_FAILURE";


export const getFinalPriceAndOffersSuccess = (object) => ({
    type: GET_FINAL_PRICE_AND_OFFERS_SUCCESS,
    payload: { 
        object: object
    }
});

export const getFinalPriceAndOffersFailure = (error) => ({
    type: GET_FINAL_PRICE_AND_OFFERS_FAILURE,
    payload: { 
        error: error
    }
}); 

export async function fetchFinalPriceAndOffers(dto) {

        try {
            var requestOptions = {
                method: 'POST',
                headers: { 
                  'Access-Control-Allow-Origin':'*',
                  'Content-Type': 'application/json', 
                },
                body : JSON.stringify(dto)
              };
            const response = await fetch(config.finalPriceEndpoint, requestOptions);
            const data = await response.json();

            return getFinalPriceAndOffersSuccess(data);

        } catch(error) {
            return getFinalPriceAndOffersFailure(error);
        }
}