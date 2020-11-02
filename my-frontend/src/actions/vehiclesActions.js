import * as config from '../config.json';

export const GET_VEHICLES_PENDING = "GET_VEHICLES_FETCHING";
export const GET_VEHICLES_SUCCESS = "GET_VEHICLES_SUCCESS";
export const GET_VEHICLES_FAILURE = "GET_VEHICLES_FAILURE";

export const getVehiclesPending = () => ({type: GET_VEHICLES_PENDING});

export const getVehiclesSuccess = (vehicles) => ({
    type: GET_VEHICLES_SUCCESS,
    payload: vehicles,
});

export const getVehiclesFailure = (error) => ({
    type: GET_VEHICLES_FAILURE,
    payload: { 
        error: error
    }
}); 

export function fetchVehicles() {

    return async dispatch => {
        dispatch(getVehiclesPending());
        
        try {
            const response = await fetch(config.vehiclesEndpoint);
            const data = await response.json();
            dispatch(getVehiclesSuccess(data));
        } catch(error) {
            dispatch(getVehiclesFailure(error));
        }
    }
}

//Hola Oscar
export function fetchVehicleById() {

    return async dispatch => {
        dispatch(getVehiclesById());
        
        try {
            const response = await fetch(config.vehiclesEndpoint);
            const data = await response.json();
            dispatch(getVehiclesSuccess(data));
        } catch(error) {
            dispatch(getVehiclesFailure(error));
        }
    }
}
