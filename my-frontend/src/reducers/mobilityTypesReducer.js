import * as actions from '../actions/mobilityTypesActions';

export const initialState = {
    objects: [],
    hasErrors: false,
    isLoading: false,
    error: ""
}

export default function mobilityTypesReducer(state = initialState, action) {
    switch(action.type) {
        case actions.GET_MOBILITYTYPES_PENDING:
            return {...state, isLoading: true};
        case actions.GET_MOBILITYTYPES_SUCCESS:
            return {objects: action.payload, isLoading: false, hasErrors: false, error: ""}
        case actions.GET_MOBILITYTYPES_FAILURE:
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