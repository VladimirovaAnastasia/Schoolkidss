import React from 'react'
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import filterFactory, { textFilter } from 'react-bootstrap-table2-filter';
import axios from "axios";



class HomeworksTable extends React.Component {

    constructor(props) {
        super(props);
    }

    handleDeletedRow(rowKeys) {
        console.log(rowKeys[0]);
        return axios
            .get('/marks/delete?id='+rowKeys[0], {"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)

            })
            .catch(error => {
                console.log(error);
            })
    }

    handleInsertedRow(row) {
        return axios
            .get(`/homeworks/create?homeworkId=${row.homeworkId}&homeworkTask=${row.homeworkTask}&subjectTitle=${row.subjectTitle}&schoolkidName=${row.schoolkidName}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
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
            // If the confirmation is true, call the function that
            // continues the deletion of the record.
            next();
        }
    }

    beforeSaveCell(row, cellName, cellValue) {
        row[cellName] = cellValue;
        return axios
            .get(`/homeworks/update?homeworkId=${row.homeworkId}&homeworkTask=${row.homeworkTask}&subjectTitle=${row.subjectTitle}&schoolkidName=${row.schoolkidName}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error);
            });
    }

    render() {
        console.log(this.props.data,'для таблицы с учениками');
        const options = {
            afterInsertRow: this.handleInsertedRow,
            handleConfirmDeleteRow: this.customConfirm,
            insertText: 'Добавить задание',
            deleteText: 'Удалить задание',
            saveText: 'Сохранить'
        };

        const selectRow = {
            mode: 'radio',
            clickToSelect: true,
            clickToSelectAndEditCell: true,
        };

        const cellEdit = {
            mode: 'dbclick', // click cell to edit
            blurToSave: true,
            beforeSaveCell: this.beforeSaveCell,
        };
//hiddenOnInsert
        return (
            <div >
                <BootstrapTable
                    hiddenOnInsert
                    hover
                    cellEdit={ cellEdit }
                    selectRow={ selectRow }
                    data={this.props.data}
                    options={ options }
                    insertRow>
                    <TableHeaderColumn hidden selectRow={ selectRow }
                                       deleteRow isKey dataField='homeworkId'>
                        ID
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='homeworkTask'>
                        Задание
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='subjectTitle'>
                        Предмет
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='schoolkidName'>
                        Имя ученика
                    </TableHeaderColumn>
                </BootstrapTable>
            </div>
        )
    }
}

export default HomeworksTable;