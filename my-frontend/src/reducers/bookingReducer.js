import * as actions from '../actions/bookingsActions';

export const initialState = {
    object: {},
    hasErrors: false,
    isLoading: false,
    error: ""
}

export default function bookingReducer(state = initialState, action) {
    
    switch(action.type) {
        case actions.POST_A_BOOKING_PENDING:
            return {...state, isLoading: true};
        case actions.POST_A_BOOKING_SUCCESS:
            return {object: action.payload, isLoading: false, hasErrors: false, error: ""}
        case actions.POST_A_BOOKING_FAILURE:
            return {
                object: {}, 
                isLoading: false, 
                hasErrors: true, 
                error: action.payload.error.message
            }
        default:
            return state;
    }
}