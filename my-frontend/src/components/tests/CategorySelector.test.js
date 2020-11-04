import React from 'react'
import CategorySelector from '../CategorySelector';
import { shallow } from 'enzyme';

describe('CategorySelector from unit test', () => {
    const items = [{id: 1, name: "Item1"}, {id: 2, name: "Item2"}, {id: 3, name: "Item3"}]

    test('should render without crashing', () => {
        const wrapper = shallow(<CategorySelector items={items} />);
        expect(wrapper).toMatchSnapshot();
    });

    test('should crash if there are no items, neither itemAll', () => {
        expect(() => {shallow(<CategorySelector />)}).toThrow();
    });

    test('should crash if items are not an array', () => {
        expect(() => {shallow(<CategorySelector items="Hola" />)}).toThrow();
        expect(() => {shallow(<CategorySelector items={4} />)}).toThrow();
    });
    
    test('should have length 1, only the itemAll', () => {
        const wrapper = shallow(<CategorySelector itemAll={true}/>);
        expect(wrapper.find('li')).toHaveLength(1)
    });

    test('should have length 3 (only items)', () => {
        const wrapper = shallow(<CategorySelector items={items}/>);
        expect(wrapper.find('li')).toHaveLength(3)
    });

    test('should have length 4 (items + itemAll)', () => {
        const wrapper = shallow(<CategorySelector items={items} itemAll={true}/>);
        expect(wrapper.find('li')).toHaveLength(4)
    });

    test('should run onClick with the new state', () => {
        const updateFilter = jest.fn();
        const wrapper = shallow(<CategorySelector items={items} filterFunction={updateFilter}/>);
        wrapper.find('#li1').simulate('click');
        expect(updateFilter).toHaveBeenCalledWith(1)
    });
});