import React, { Component } from "react";
import {Home} from './pages/Home'
import {Schoolkid} from './pages/Schoolkid'
import {Subject} from './pages/Subject'
import {Teacher} from './pages/Teacher'
import {Mark} from './pages/Mark'
import {Homework} from './pages/Homework'
import './App.css';
import {Navbar} from  "./components/Navbar";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {auth: true};
    };

    render() {
        return (
            <Router>
                <Navbar />
                <Switch>
                    <Route path='/' exact component={Home} />
                    <Route path='/schoolkids' component={Schoolkid} />
                    <Route path='/teachers' component={Teacher} />
                    <Route path='/subjects' component={Subject} />
                    <Route path='/marks' component={Mark} />
                    <Route path='/homeworks' component={Homework} />
                </Switch>
            </Router>
        );
    }
}

export default App;

