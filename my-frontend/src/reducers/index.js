import { combineReducers } from 'redux'

import vehiclesReducer from './vehiclesReducer'
import mobilityTypesReducer from './mobilityTypesReducer'

const rootReducer = combineReducers({
  vehicles: vehiclesReducer,
  mobilityTypes: mobilityTypesReducer
})

export default rootReducer