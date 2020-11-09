import * as config from '../config.json';

export const RESET_FINAL_PRICE_AND_OFFERS = "RESET_FINAL_PRICE_AND_OFFERS";
export const GET_FINAL_PRICE_AND_OFFERS_PENDING = "GET_FINAL_PRICE_AND_OFFERS_PENDING";
export const GET_FINAL_PRICE_AND_OFFERS_SUCCESS = "GET_FINAL_PRICE_AND_OFFERS_SUCCESS";
export const GET_FINAL_PRICE_AND_OFFERS_FAILURE = "GET_FINAL_PRICE_AND_OFFERS_FAILURE";

export const resetFinalPriceAndOffers = () => ({type: RESET_FINAL_PRICE_AND_OFFERS});
export const getFinalPriceAndOffersPending = () => ({type: GET_FINAL_PRICE_AND_OFFERS_PENDING});


export const getFinalPriceAndOffersSuccess = (object) => ({
    type: GET_FINAL_PRICE_AND_OFFERS_SUCCESS,
    payload: object
});

export const getFinalPriceAndOffersFailure = (error) => ({
    type: GET_FINAL_PRICE_AND_OFFERS_FAILURE,
    payload: {
        error: error
    }
});

export function fetchResetFinalPriceAndOffers(){
    return async dispatch => {dispatch(resetFinalPriceAndOffers());}
}

export function fetchFinalPriceAndOffers(dto) {
    return async dispatch => {
        dispatch(getFinalPriceAndOffersPending());
        try {
            var requestOptions = {
                method: 'POST',
                headers: {
                    'Access-Control-Allow-Origin': '*',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(dto)
            };
            const response = await fetch(config.finalPriceEndpoint, requestOptions);
            const data = await response.json();

            dispatch(getFinalPriceAndOffersSuccess(data));

        } catch (error) {
            dispatch(getFinalPriceAndOffersFailure(error));
        }
    }
}