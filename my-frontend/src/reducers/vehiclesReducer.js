import * as actions from '../actions/vehiclesActions';

export const initialStateAll = {
    objects: [],
    hasErrors: false,
    isLoading: false,
    error: ""
}

export const initialStateOne = {
    object: {},
    hasErrors: false,
    isLoading: false,
    error: ""
}

export function vehiclesReducer(state = initialStateAll, action) {
    switch(action.type) {
        case actions.GET_VEHICLES_PENDING:
            return {...state, isLoading: true};
        case actions.GET_VEHICLES_SUCCESS:
            return {objects: action.payload, isLoading: false, hasErrors: false, error: ""}
        case actions.GET_VEHICLES_FAILURE:
            return {
                objects: [], 
                isLoading: false, 
                hasErrors: true, 
                error: action.payload.error.message
            }
        default:
            return state;
    }
}

export function vehicleReducer(state = initialStateOne, action) {
    switch(action.type) {
        case actions.GET_VEHICLE_PENDING:
            return {...state, isLoading: true};
        case actions.GET_VEHICLE_SUCCESS:
            return {object: action.payload, isLoading: false, hasErrors: false, error: ""}
        case actions.GET_VEHICLE_FAILURE:
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