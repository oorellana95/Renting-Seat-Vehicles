import * as config from '../config.json';

export const GET_MOBILITYTYPES_PENDING = "GET_MOBILITYTYPES_FETCHING";
export const GET_MOBILITYTYPES_SUCCESS = "GET_MOBILITYTYPES_SUCCESS";
export const GET_MOBILITYTYPES_FAILURE = "GET_MOBILITYTYPES_FAILURE";

export const getMobilityTypesPending = () => ({type: GET_MOBILITYTYPES_PENDING});

export const getMobilityTypesSuccess = (objects) => ({
    type: GET_MOBILITYTYPES_SUCCESS,
    payload: objects,
});

export const getMobilityTypesFailure = (error) => ({
    type: GET_MOBILITYTYPES_FAILURE,
    payload: { 
        error: error
    }
}); 

export function fetchMobilityTypes() {

    return async dispatch => {
        dispatch(getMobilityTypesPending());
        
        try {
            const response = await fetch(config.mobilityTypesEndpoint);
            const data = await response.json();
            dispatch(getMobilityTypesSuccess(data));
        } catch(error) {
            dispatch(getMobilityTypesFailure(error));
        }
    }
}
