import React from 'react'
import NumSelector from '../NumSelector';
import { shallow } from 'enzyme';

describe('NumSelector from unit test', () => {
    test('it should render without crashing', () => {
        const wrapper = shallow(<NumSelector nums={[1,2,4,5,7]} />);
        expect(wrapper).toMatchSnapshot();
    });

    test('it should crash if there is no array of nums or if it is not an array', () => {
        expect(() => {shallow(<NumSelector/>)}).toThrow();
        expect(() => {shallow(<NumSelector nums="Hola" />)}).toThrow();
        expect(() => {shallow(<NumSelector nums={4} />)}).toThrow();
    });
    

    test('should have length 5', () => {
        const wrapper = shallow(<NumSelector nums={[1,2,4,5,7]}/>);
        expect(wrapper.find('li')).toHaveLength(5)
    });

    test('should run onClick with the new state', () => {
        const updateFilter = jest.fn();
        const wrapper = shallow(<NumSelector nums={[1,2,4,5,7]} filterFunction={updateFilter}/>);
        //Si simulo un click en el li 1, la funcion updateFilter (filterFunction) se ha de ejecutar con el 1
        // target:{value: x}
        wrapper.find('#li1').simulate('click');
        expect(updateFilter).toHaveBeenCalledWith(1)
    });
});
