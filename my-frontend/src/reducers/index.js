import { combineReducers } from 'redux'

import vehiclesReducer from './vehiclesReducer'

const rootReducer = combineReducers({
  vehicles: vehiclesReducer
})

export default rootReducer