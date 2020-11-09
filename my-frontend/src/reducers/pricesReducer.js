import { dtoOffersPrices } from 'dto/dtoOffersPrices';
import * as actions from '../actions/pricesActions';

export const initialState = {
    object: new dtoOffersPrices(),
    hasErrors: false,
    isLoading: false,
    error: ""
}

export default function pricesReducer(state = initialState, action) {
    
    switch(action.type) {
        case actions.RESET_FINAL_PRICE_AND_OFFERS:
            return initialState;
        case actions.GET_FINAL_PRICE_AND_OFFERS_PENDING:
            return {...state, isLoading: true};
        case actions.GET_FINAL_PRICE_AND_OFFERS_SUCCESS:
            return {object: action.payload, isLoading: false, hasErrors: false, error: ""}
        case actions.GET_FINAL_PRICE_AND_OFFERS_FAILURE:
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