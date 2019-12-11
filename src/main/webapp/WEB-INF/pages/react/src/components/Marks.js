import React from 'react'
import MarksTable from "./MarksTable";

class Marks extends React.Component {

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
        const url = await fetch(`/marks/getAll`);
        const data = await url.json();
        console.log(data);
        const marksInfo = data;
        marksInfo.map(function(item){
            item.schoolkidName = item.schoolkids.schoolkidName;
            item.subjectTitle = item.subjects.subjectTitle;
        });
        this.setState({
            data:marksInfo,
        });

    };

    render() {
        return (
            <div>
                <MarksTable data={this.state.data} />
            </div>
        )
    }

}

export default Marks;
