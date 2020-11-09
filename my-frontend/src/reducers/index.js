import { combineReducers } from 'redux'

import {vehicleReducer, vehiclesReducer} from './vehiclesReducer'
import mobilityTypesReducer from './mobilityTypesReducer'
import bookingReducer from './bookingReducer'
import pricesReducer from './pricesReducer'

const rootReducer = combineReducers({
  vehicle: vehicleReducer,
  prices: pricesReducer,
  vehicles: vehiclesReducer,
  booking: bookingReducer,
  mobilityTypes: mobilityTypesReducer
})

export default rootReducer