import React from 'react'
import SchoolkidsTable from "../components/SchoolkidsTable";

class Schoolkids extends React.Component {

    constructor(props) {
        super(props);
        this.state = {value: ''};
    }

    componentDidMount() {
        this.processUpdate()
    }

    processUpdate() {
        this.getAll().then(r => {
                return r
            }
        )
    }

    getAll = async () => {
        const url = await fetch(`/schoolkids/get`);
        const data = await url.json();
        console.log(data);
        this.setState({
            data: data,
        })
    };

    render() {
        return (
            <div>
                <SchoolkidsTable data={this.state.data} />
            </div>
        )
    }

}

export default Schoolkids;
