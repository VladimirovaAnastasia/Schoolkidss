import React from 'react'
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import axios from "axios";
import SchoolkidsInfo from "../components/SchoolkidsInfo";


class SchoolkidsTable extends React.Component {

    constructor(props) {
        super(props);
    }

    handleDeletedRow(rowKeys) {
        console.log(rowKeys[0]);
        return axios
            .get('/schoolkids/delete?id='+rowKeys[0], {"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error);
            })
    }

    handleInsertedRow(row) {
        console.log(`${row.schoolkidId}&${row.schoolkidName}&${row.schoolkidYearofstudy}`);
        //let id = Number.parseInt(row.schoolkidId.substring(10,3));
        //console.log(id,typeof (id))
        return axios
            .get(`/schoolkids/create?schoolkidId=${row.schoolkidId}&schoolkidName=${row.schoolkidName}&schoolkidYearofstudy=${row.schoolkidYearofstudy}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error);
            });
    }

    customConfirm(next, dropRowKeys){
        const dropRowKeysStr = dropRowKeys.join(',');
        if (window.confirm(`Вы уверены, что хотите удалить ${dropRowKeysStr}?`)) {
            next();
        }
    }

    beforeSaveCell(row, cellName, cellValue) {
        row[cellName] = cellValue;
        return axios
            .get(`/schoolkids/update?schoolkidId=${row.schoolkidId}&schoolkidName=${row.schoolkidName}&schoolkidYearofstudy=${row.schoolkidYearofstudy}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error);
            });
        // if you dont want to save this editing, just return false to cancel it.
    }

    isExpandableRow(row) {
        return true;
    }

    expandComponent(row) {
        console.log('Это инфа по ученику', row.schoolkidId);
        return (
              <SchoolkidsInfo data={row.schoolkidId}/>
        );
    }

    render() {
        console.log(this.props.data,'для таблицы с учениками')
        const options = {
            afterDeleteRow: this.handleDeletedRow,
            afterInsertRow: this.handleInsertedRow,
            handleConfirmDeleteRow: this.customConfirm,
            expandRowBgColor: 'rgb(242, 255, 163)',
            insertText: 'Добавить ученика',
            deleteText: 'Удалить ученика',
            saveText: 'Сохранить'
        };

        const selectRow = {
            mode: 'radio',
            clickToSelect: true,
            clickToSelectAndEditCell: true,
            clickToExpand: true
        };

        const cellEdit = {
            mode: 'dbclick', // click cell to edit
            blurToSave: true,
            beforeSaveCell: this.beforeSaveCell,
            clickToExpand: true
        };

        return (
            <div className="customTable">
                <BootstrapTable
                    cellEdit={ cellEdit }
                    selectRow={ selectRow }
                    data={this.props.data}
                    deleteRow
                    hover
                    options={ options }
                    insertRow
                    expandableRow={ this.isExpandableRow }
                    expandComponent={ this.expandComponent }
                    expandColumnOptions={ { expandColumnVisible: true } }>
                    <TableHeaderColumn hidden
                                       selectRow={ selectRow }
                                       isKey dataField='schoolkidId'>
                        ID
                    </TableHeaderColumn>
                    <TableHeaderColumn width='150px' deleteRow dataField='schoolkidName'>
                        Полное имя
                    </TableHeaderColumn>
                    <TableHeaderColumn width='150px' deleteRow dataField='schoolkidYearofstudy'>
                        Год обучения
                    </TableHeaderColumn>
                </BootstrapTable>
            </div>
        )
    }
}

export default SchoolkidsTable;