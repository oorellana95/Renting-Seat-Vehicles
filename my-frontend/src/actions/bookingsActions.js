import * as config from '../config.json';

export const POST_A_BOOKING_SUCCESS = "POST_A_BOOKING_SUCCESS";
export const POST_A_BOOKING_FAILURE = "POST_A_BOOKING_FAILURE";

export const postABookingSuccess = (success) => ({
    type: POST_A_BOOKING_SUCCESS,
    payload: { 
        success: success
    }
});

export const postABookingFailure = (error) => ({
    type: POST_A_BOOKING_FAILURE,
    payload: { 
        error: error
    }
}); 

export async function fetchPostBooking(dto) {

  try {
      var requestOptions = {
          method: 'POST',
          headers: { 
            'Access-Control-Allow-Origin':'*',
            'Content-Type': 'application/json', 
          },
          body : JSON.stringify(dto)
        };
      const response = await fetch(config.bookingsEndpoint, requestOptions);
      const data = await response.json();

      return postABookingSuccess(data);

  } catch(error) {
      return postABookingFailure(error);
  }
}