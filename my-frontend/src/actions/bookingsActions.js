import * as config from '../config.json';

export const POST_A_BOOKING_PENDING = "POST_A_BOOKING_PENDING";
export const POST_A_BOOKING_SUCCESS = "POST_A_BOOKING_SUCCESS";
export const POST_A_BOOKING_FAILURE = "POST_A_BOOKING_FAILURE";


export const postABookingPending = () => ({type: POST_A_BOOKING_PENDING});

export const postABookingSuccess = (object) => ({
    type: POST_A_BOOKING_SUCCESS,
    payload: object
});

export const postABookingFailure = (error) => ({
    type: POST_A_BOOKING_FAILURE,
    payload: { 
        error: error
    }
}); 

export function fetchPostBooking(dto) {
    return async dispatch => {
        dispatch(postABookingPending());
        try {
            var requestOptions = {
                method: 'POST',
                headers: {
                    'Access-Control-Allow-Origin': '*',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(dto)
            };
            const response = await fetch(config.postBookingEndpoint, requestOptions);
            const data = await response.json();

            dispatch(postABookingSuccess(data));

        } catch (error) {
            dispatch(postABookingFailure(error));
        }
    }
}