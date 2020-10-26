import * as actions from '../actions/vehiclesActions';

export const initialState = {
    vehicles: [],
    hasErrors: false,
    isLoading: false,
    error: ""
}

export default function vehiclesReducer(state = initialState, action) {
    switch(action.type) {
        case actions.GET_VEHICLES_PENDING:
            return {...state, isLoading: true};
        case actions.GET_VEHICLES_SUCCESS:
            return {vehicles: action.payload, isLoading: false, hasErrors: false, error: ""}
        case actions.GET_VEHICLES_FAILURE:
            return {
                vehicles: [], 
                isLoading: false, 
                hasErrors: true, 
                error: action.payload.error.message
            }
        default:
            return state;
    }
}