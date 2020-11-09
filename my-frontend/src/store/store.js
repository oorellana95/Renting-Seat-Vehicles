import { createStore} from 'redux'
import { persistStore, persistReducer } from 'redux-persist' // imports from redux-persist
import storageSession from 'redux-persist/lib/storage' // defaults to localStorage for web
import { composeWithDevTools } from 'redux-devtools-extension';
import rootReducer from '../reducers' // Root reducer

const persistConfig = { // configuration object for redux-persist
    key: 'root',
    storage: storageSession, // define which storage to use
}

const persistedReducer = persistReducer(persistConfig, rootReducer) // create a persisted reducer

const store = createStore(
    persistedReducer, // pass the persisted reducer instead of rootReducer to createStore
    composeWithDevTools()
)

const  persistor = persistStore(store); // used to create the persisted store, persistor will be used in the next step

export {store, persistor}