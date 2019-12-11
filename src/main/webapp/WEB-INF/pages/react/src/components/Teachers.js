import React from 'react'
import TeachersTable from "../components/TeachersTable";

class Teachers extends React.Component {

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
        const url = await fetch(`/teachers/get`);
        const data = await url.json();
        console.log(data);
        this.setState({
            data: data,
        })
    };

    render() {
        return (
            <div>
                <TeachersTable data={this.state.data} />
            </div>
        )
    }

}

export default Teachers;
