import React from 'react'
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import axios from "axios";


class SubjectsTable extends React.Component {
    handleDeletedRow(rowKeys) {
        console.log(rowKeys[0]);
        return axios
            .get('/subjects/delete?id='+rowKeys[0], {"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)

            })
            .catch(error => {
                console.log(error);
            })
    }

    handleInsertedRow(row) {
        console.log(`${row.subjectId}&${row.subjectStartyear}&${row.schoolkidYearofstudy}`)
        return axios
            .get(`/subjects/create?subjectId=${row.subjectId}&subjectStartyear=${row.subjectStartyear}&subjectTitle=${row.subjectTitle}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
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
            .get(`/subjects/update?subjectId=${row.subjectId}&subjectStartyear=${row.subjectStartyear}&subjectTitle=${row.subjectTitle}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error);
            });
    }

    render() {
        const options = {
            afterDeleteRow: this.handleDeletedRow,
            afterInsertRow: this.handleInsertedRow,
            handleConfirmDeleteRow: this.customConfirm,
            insertText: 'Добавить предмет',
            deleteText: 'Удалить предмет',
            saveText: 'Сохранить'
        };

        const selectRow = {
            mode: 'radio',
            clickToSelect: true,
            clickToSelectAndEditCell: true,
            unselectable: [ 'row1' ]
        };

        const cellEdit = {
            mode: 'dbclick', // click cell to edit
            beforeSaveCell: this.beforeSaveCell,
            blurToSave: true
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
                                       deleteRow isKey dataField='subjectId'>
                        ID
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='subjectStartyear'>
                        Начальный год обучения
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='subjectTitle'>
                        Название предмета
                    </TableHeaderColumn>
                </BootstrapTable>
            </div>
        )
    }
}

export default SubjectsTable;