import * as config from '../config.json';

export const GET_VEHICLES_PENDING = "GET_VEHICLES_FETCHING";
export const GET_VEHICLE_PENDING = "GET_VEHICLE_FETCHING";

export const GET_VEHICLES_SUCCESS = "GET_VEHICLES_SUCCESS";
export const GET_VEHICLE_SUCCESS = "GET_VEHICLE_SUCCESS";

export const GET_VEHICLES_FAILURE = "GET_VEHICLES_FAILURE";
export const GET_VEHICLE_FAILURE = "GET_VEHICLE_FAILURE";

export const getVehiclesPending = () => ({type: GET_VEHICLES_PENDING});
export const getVehicleByIdPending = () => ({type: GET_VEHICLE_PENDING});

export const getVehiclesSuccess = (objects) => ({
    type: GET_VEHICLES_SUCCESS,
    payload: objects,
});
export const getVehicleByIdSuccess = (object) => ({
    type: GET_VEHICLE_SUCCESS,
    payload: object,
});

export const getVehiclesFailure = (error) => ({
    type: GET_VEHICLES_FAILURE,
    payload: { 
        error: error
    }
}); 
export const getVehicleByIdFailure = (error) => ({
    type: GET_VEHICLE_FAILURE,
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

export function fetchVehicleById(id) {

    return async dispatch => {
        dispatch(getVehicleByIdPending());
        
        try {
            const response = await fetch(`${config.vehiclesEndpoint}/${id}`);
            const data = await response.json();
            dispatch(getVehicleByIdSuccess(data));
        } catch(error) {
            dispatch(getVehicleByIdFailure(error));
        }
    }
}
