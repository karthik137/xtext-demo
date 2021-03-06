/**
 * generated by Xtext 2.21.0
 */
package org.example.domainmodel.generator;

import com.google.common.collect.Iterables;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.example.domainmodel.domainmodel.Entity;
import org.example.domainmodel.domainmodel.Feature;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class DomainmodelGenerator extends AbstractGenerator {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Entity> _filter = Iterables.<Entity>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Entity.class);
    for (final Entity e : _filter) {
      String _string = this._iQualifiedNameProvider.getFullyQualifiedName(e).toString("/");
      String _plus = (_string + ".java");
      fsa.generateFile(_plus, 
        this.compile(e));
    }
  }
  
  private CharSequence compile(final Entity e) {
    StringConcatenation _builder = new StringConcatenation();
    {
      QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(e.eContainer());
      boolean _tripleNotEquals = (_fullyQualifiedName != null);
      if (_tripleNotEquals) {
        _builder.append("package ");
        QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(e.eContainer());
        _builder.append(_fullyQualifiedName_1);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class");
    String _name = e.getName();
    _builder.append(_name, "\t");
    _builder.append(" ");
    {
      Entity _superType = e.getSuperType();
      boolean _tripleNotEquals_1 = (_superType != null);
      if (_tripleNotEquals_1) {
        _builder.append(" extends ");
        QualifiedName _fullyQualifiedName_2 = this._iQualifiedNameProvider.getFullyQualifiedName(e.getSuperType());
        _builder.append(_fullyQualifiedName_2, "\t");
      }
    }
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      EList<Feature> _features = e.getFeatures();
      for(final Feature f : _features) {
        _builder.append("\t\t\t");
        CharSequence _compile = this.compile(f);
        _builder.append(_compile, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      EList<Feature> _features_1 = e.getFeatures();
      for(final Feature f_1 : _features_1) {
        _builder.append("\t\t\t");
        CharSequence _compileFuntions = this.compileFuntions(f_1);
        _builder.append(_compileFuntions, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence compile(final Feature f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(f.getType());
    _builder.append(_fullyQualifiedName);
    _builder.append(" ");
    String _name = f.getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence compileFuntions(final Feature f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(f.getType());
    _builder.append(_fullyQualifiedName);
    _builder.append(" get");
    String _firstUpper = StringExtensions.toFirstUpper(f.getName());
    _builder.append(_firstUpper);
    _builder.append("(){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _name = f.getName();
    _builder.append(_name, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public void set");
    String _firstUpper_1 = StringExtensions.toFirstUpper(f.getName());
    _builder.append(_firstUpper_1);
    _builder.append("(");
    QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(f.getType());
    _builder.append(_fullyQualifiedName_1);
    _builder.append(" ");
    String _name_1 = f.getName();
    _builder.append(_name_1);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_2 = f.getName();
    _builder.append(_name_2, "\t");
    _builder.append(" = ");
    String _name_3 = f.getName();
    _builder.append(_name_3, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    return _builder;
  }
}
