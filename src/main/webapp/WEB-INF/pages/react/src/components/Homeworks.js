import React from 'react'
import HomeworksTable from "./HomeworksTable";


class Homeworks extends React.Component {

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
        const url = await fetch(`/homeworks/getAll`);
        const data = await url.json();
        console.log(data);
        const homeworksInfo = data;
        homeworksInfo.map(function(item){
            item.schoolkidName = item.schoolkids.schoolkidName;
            item.subjectTitle = item.subjects.subjectTitle;
        });
        this.setState({
            data:homeworksInfo,
        });
    };

    render() {
        return (
            <div>
                <HomeworksTable data={this.state.data} />
            </div>
        )
    }

}

export default Homeworks;
