/**
 * this file is auto generated by TTO-CodeGenerator v{{.global.Version}} !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/ixre/tto
 *
 */
!target:java/{{.global.Pkg}}/pojo/{{.table.Title}}Entity.java
package {{pkg "java" .global.Pkg}}.pojo;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

/** {{.table.Comment}} */
@Entity
@Table(name = "{{.table.Name}}", schema = "{{.table.Schema}}")
public class {{.table.Title}}Entity {
    {{range $i,$c := .columns}}{{$type := type "java" $c.TypeId}}
    private {{$type}} {{$c.Name}};
    public void set{{$c.Title}}({{$type}} {{$c.Name}}){
        this.{{$c.Name}} = {{$c.Name}};
    }

    /** {{$c.Comment}} */{{if $c.IsPk}}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY){{else}}
    @Basic{{end}}
    @Column(name = "{{$c.Name}}"{{if not $c.NotNull}}, nullable = true{{end}} {{if ne $c.Length 0}},length = {{$c.Length}}{{end}})
    public {{$type}} get{{$c.Title}}() {
        return this.{{$c.Name}};
    }
    {{end}}
}
