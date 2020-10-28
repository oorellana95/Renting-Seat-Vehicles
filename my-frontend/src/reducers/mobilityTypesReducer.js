import * as actions from '../actions/mobilityTypesActions';

export const initialState = {
    mobilityTypes: [],
    hasErrors: false,
    isLoading: false,
    error: ""
}

export default function mobilityTypesReducer(state = initialState, action) {
    switch(action.type) {
        case actions.GET_MOBILITYTYPES_PENDING:
            return {...state, isLoading: true};
        case actions.GET_MOBILITYTYPES_SUCCESS:
            return {mobilityTypes: action.payload, isLoading: false, hasErrors: false, error: ""}
        case actions.GET_MOBILITYTYPES_FAILURE:
            return {
                mobilityTypes: [], 
                isLoading: false, 
                hasErrors: true, 
                error: action.payload.error.message
            }
        default:
            return state;
    }
}