import * as config from '../config.json';

export const CALCULATE_FINAL_PRICE_SUCCESS = "CALCULATE_FINAL_PRICE_SUCCESS";
export const CALCULATE_FINAL_PRICE_FAILURE = "CALCULATE_FINAL_PRICE_FAILURE";


export const calculateFinalPriceSuccess = (price) => ({
    type: CALCULATE_FINAL_PRICE_SUCCESS,
    payload: { 
        price: price
    }
});

export const calculateFinalPriceFailure = (error) => ({
    type: CALCULATE_FINAL_PRICE_FAILURE,
    payload: { 
        error: error
    }
}); 

export async function fetchCalculateFinalPrice(dto) {

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

            return calculateFinalPriceSuccess(data);

        } catch(error) {
            return calculateFinalPriceFailure(error);
        }
}