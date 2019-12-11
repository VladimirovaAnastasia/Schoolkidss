import React from 'react'
import SubjectsTable from "../components/SubjectsTable";


class Subjects extends React.Component {

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
        const url = await fetch(`/subjects/get`);
        const data = await url.json();
        console.log(data);
        this.setState({
            data: data,
        })
    };

    render() {
        return (
            <div>
                <SubjectsTable data={this.state.data} />
            </div>
        )
    }

}

export default Subjects;
