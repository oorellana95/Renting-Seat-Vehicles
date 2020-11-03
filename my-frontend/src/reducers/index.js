import { combineReducers } from 'redux'

import {vehicleReducer, vehiclesReducer} from './vehiclesReducer'
import mobilityTypesReducer from './mobilityTypesReducer'

const rootReducer = combineReducers({
  vehicle: vehicleReducer,
  vehicles: vehiclesReducer,
  mobilityTypes: mobilityTypesReducer
})

export default rootReducer