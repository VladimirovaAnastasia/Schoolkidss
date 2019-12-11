import React from 'react'
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import axios from "axios";

let mydata =[];

class SchoolkidsInfo extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            schoolkidInfo: [{
                markDate: '',
                markPoint:'',
                markSubject:'',
                schoolkidId:''
            }]
        };
    }

    componentDidMount() {
        this.processUpdate();
    }

    processUpdate() {
        if (this.props.data){
            const test = this.props.data;
            console.log(test)
            console.log(`/marks/get?schoolkidId=${this.props.data}`);
            return axios
                .get(`/marks/get?schoolkidId=${this.props.data}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
                .then(response => {
                    let schoolkidsInfo = response.data;
                    if (schoolkidsInfo.length>0){

                        mydata = this.props.data;
                        let schoolkid = [];

                        schoolkidsInfo.map(function(item, i){
                            schoolkid.push({
                                markDate : item.markDate,
                                markPoint : item.markPoint,
                                markSubject : item.subjects.subjectTitle,
                                schoolkidId : test
                            });
                        });
                        this.setState({
                            schoolkidInfo:schoolkid,
                        });
                    } else {
                        this.setState({
                            schoolkidInfo:[
                                {
                                    markDate: '',
                                    markPoint:'',
                                    markSubject:'',
                                    schoolkidId:''
                                }
                            ],
                        });
                    }

                })
                .catch(error => {
                    console.log(error);
                });
        }
    }

    getProps(){
        console.log(this.props.data);
        return (this.props.data)
    }

    handleInsertedRow(row) {
        return axios
            .get(`/marks/create?schoolkidId=${mydata}&markDate=${row.markDate}&markPoint=${row.markPoint}&markSubject=${row.markSubject}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error);
            });
    };

    render() {

        const options = {
            afterDeleteRow: this.handleDeletedRow,
            afterInsertRow: this.handleInsertedRow,
        };


        let mainData = this.state.schoolkidInfo;
        if (mainData[0].markDate === '') {
            return (<p>Данных не обнаружено</p>);
        } else {

            return (
                <BootstrapTable
                    data={mainData}
                    options={ options }
                    hover>
                    <TableHeaderColumn  isKey
                                        dataField='markDate'
                                        dataAlign='center'
                                        headerAlign="center"
                                        width='150px'>
                        Дата
                    </TableHeaderColumn>
                    <TableHeaderColumn  dataField='markPoint'
                                        dataAlign='center'
                                        headerAlign="center"
                                        width='150px'>
                        Оценка
                    </TableHeaderColumn>
                    <TableHeaderColumn  dataField='markSubject'
                                        dataAlign='center'
                                        headerAlign="center"
                                        width='150px'>
                        Предмет
                    </TableHeaderColumn>
                </BootstrapTable>
            );
        }
    }
}

export default SchoolkidsInfo;