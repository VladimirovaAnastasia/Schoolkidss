import React from 'react'
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import axios from "axios";


class MarksTable extends React.Component {

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
            .get(`/marks/createNew?markId=${row.markId}&markPoint=${row.markPoint}&markDate=${row.markDate}&schoolkidName=${row.schoolkidName}&subjectTitle=${row.subjectTitle}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
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
            .get(`/marks/update?markId=${row.markId}&markPoint=${row.markPoint}&markDate=${row.markDate}&schoolkidName=${row.schoolkidName}&subjectTitle=${row.subjectTitle}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
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
            afterDeleteRow: this.handleDeletedRow,
            afterInsertRow: this.handleInsertedRow,
            handleConfirmDeleteRow: this.customConfirm,
            insertText: 'Добавить оценку',
            deleteText: 'Удалить оценку',
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

        return (
            <div>
                <BootstrapTable
                    cellEdit={ cellEdit }
                    selectRow={ selectRow }
                    data={this.props.data}
                    deleteRow
                    options={ options }
                    insertRow
                    hover>
                    <TableHeaderColumn hidden
                                       selectRow={ selectRow }
                                       deleteRow isKey dataField='markId'>
                        ID
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='markPoint'>
                        Оценка
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='subjectTitle'>
                        Предмет
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='markDate'>
                        Дата
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='schoolkidName'>
                        Имя ученика
                    </TableHeaderColumn>
                </BootstrapTable>
            </div>
        )
    }
}

export default MarksTable;