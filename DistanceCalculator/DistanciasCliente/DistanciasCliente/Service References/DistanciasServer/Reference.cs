﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace DistanciasCliente.DistanciasServer {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://server/", ConfigurationName="DistanciasServer.DistanciasServer")]
    public interface DistanciasServer {
        
        // CODEGEN: Parameter 'arg1' requires additional schema information that cannot be captured using the parameter mode. The specific attribute is 'System.Xml.Serialization.XmlArrayAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://server/DistanciasServer/calcularDistanciaMultiplasCidadesRequest", ReplyAction="http://server/DistanciasServer/calcularDistanciaMultiplasCidadesResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesResponse calcularDistanciaMultiplasCidades(DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://server/DistanciasServer/calcularDistanciaMultiplasCidadesRequest", ReplyAction="http://server/DistanciasServer/calcularDistanciaMultiplasCidadesResponse")]
        System.Threading.Tasks.Task<DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesResponse> calcularDistanciaMultiplasCidadesAsync(DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesRequest request);
        
        // CODEGEN: Parameter 'return' requires additional schema information that cannot be captured using the parameter mode. The specific attribute is 'System.Xml.Serialization.XmlArrayAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://server/DistanciasServer/calcularDistanciaMaximaRequest", ReplyAction="http://server/DistanciasServer/calcularDistanciaMaximaResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        DistanciasCliente.DistanciasServer.calcularDistanciaMaximaResponse calcularDistanciaMaxima(DistanciasCliente.DistanciasServer.calcularDistanciaMaximaRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://server/DistanciasServer/calcularDistanciaMaximaRequest", ReplyAction="http://server/DistanciasServer/calcularDistanciaMaximaResponse")]
        System.Threading.Tasks.Task<DistanciasCliente.DistanciasServer.calcularDistanciaMaximaResponse> calcularDistanciaMaximaAsync(DistanciasCliente.DistanciasServer.calcularDistanciaMaximaRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://server/DistanciasServer/calcularDistanciaDuasCidadesRequest", ReplyAction="http://server/DistanciasServer/calcularDistanciaDuasCidadesResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(Style=System.ServiceModel.OperationFormatStyle.Rpc, SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        string calcularDistanciaDuasCidades(string arg0, string arg1);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://server/DistanciasServer/calcularDistanciaDuasCidadesRequest", ReplyAction="http://server/DistanciasServer/calcularDistanciaDuasCidadesResponse")]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        System.Threading.Tasks.Task<string> calcularDistanciaDuasCidadesAsync(string arg0, string arg1);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="calcularDistanciaMultiplasCidades", WrapperNamespace="http://server/", IsWrapped=true)]
    public partial class calcularDistanciaMultiplasCidadesRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="", Order=0)]
        public string arg0;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="", Order=1)]
        [System.Xml.Serialization.XmlArrayAttribute()]
        [System.Xml.Serialization.XmlArrayItemAttribute("item", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string[] arg1;
        
        public calcularDistanciaMultiplasCidadesRequest() {
        }
        
        public calcularDistanciaMultiplasCidadesRequest(string arg0, string[] arg1) {
            this.arg0 = arg0;
            this.arg1 = arg1;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="calcularDistanciaMultiplasCidadesResponse", WrapperNamespace="http://server/", IsWrapped=true)]
    public partial class calcularDistanciaMultiplasCidadesResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="", Order=0)]
        public string @return;
        
        public calcularDistanciaMultiplasCidadesResponse() {
        }
        
        public calcularDistanciaMultiplasCidadesResponse(string @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="calcularDistanciaMaxima", WrapperNamespace="http://server/", IsWrapped=true)]
    public partial class calcularDistanciaMaximaRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="", Order=0)]
        public string arg0;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="", Order=1)]
        public int arg1;
        
        public calcularDistanciaMaximaRequest() {
        }
        
        public calcularDistanciaMaximaRequest(string arg0, int arg1) {
            this.arg0 = arg0;
            this.arg1 = arg1;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="calcularDistanciaMaximaResponse", WrapperNamespace="http://server/", IsWrapped=true)]
    public partial class calcularDistanciaMaximaResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="", Order=0)]
        [System.Xml.Serialization.XmlArrayAttribute()]
        [System.Xml.Serialization.XmlArrayItemAttribute("item", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string[] @return;
        
        public calcularDistanciaMaximaResponse() {
        }
        
        public calcularDistanciaMaximaResponse(string[] @return) {
            this.@return = @return;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface DistanciasServerChannel : DistanciasCliente.DistanciasServer.DistanciasServer, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class DistanciasServerClient : System.ServiceModel.ClientBase<DistanciasCliente.DistanciasServer.DistanciasServer>, DistanciasCliente.DistanciasServer.DistanciasServer {
        
        public DistanciasServerClient() {
        }
        
        public DistanciasServerClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public DistanciasServerClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public DistanciasServerClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public DistanciasServerClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesResponse DistanciasCliente.DistanciasServer.DistanciasServer.calcularDistanciaMultiplasCidades(DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesRequest request) {
            return base.Channel.calcularDistanciaMultiplasCidades(request);
        }
        
        public string calcularDistanciaMultiplasCidades(string arg0, string[] arg1) {
            DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesRequest inValue = new DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesRequest();
            inValue.arg0 = arg0;
            inValue.arg1 = arg1;
            DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesResponse retVal = ((DistanciasCliente.DistanciasServer.DistanciasServer)(this)).calcularDistanciaMultiplasCidades(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesResponse> DistanciasCliente.DistanciasServer.DistanciasServer.calcularDistanciaMultiplasCidadesAsync(DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesRequest request) {
            return base.Channel.calcularDistanciaMultiplasCidadesAsync(request);
        }
        
        public System.Threading.Tasks.Task<DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesResponse> calcularDistanciaMultiplasCidadesAsync(string arg0, string[] arg1) {
            DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesRequest inValue = new DistanciasCliente.DistanciasServer.calcularDistanciaMultiplasCidadesRequest();
            inValue.arg0 = arg0;
            inValue.arg1 = arg1;
            return ((DistanciasCliente.DistanciasServer.DistanciasServer)(this)).calcularDistanciaMultiplasCidadesAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        DistanciasCliente.DistanciasServer.calcularDistanciaMaximaResponse DistanciasCliente.DistanciasServer.DistanciasServer.calcularDistanciaMaxima(DistanciasCliente.DistanciasServer.calcularDistanciaMaximaRequest request) {
            return base.Channel.calcularDistanciaMaxima(request);
        }
        
        public string[] calcularDistanciaMaxima(string arg0, int arg1) {
            DistanciasCliente.DistanciasServer.calcularDistanciaMaximaRequest inValue = new DistanciasCliente.DistanciasServer.calcularDistanciaMaximaRequest();
            inValue.arg0 = arg0;
            inValue.arg1 = arg1;
            DistanciasCliente.DistanciasServer.calcularDistanciaMaximaResponse retVal = ((DistanciasCliente.DistanciasServer.DistanciasServer)(this)).calcularDistanciaMaxima(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<DistanciasCliente.DistanciasServer.calcularDistanciaMaximaResponse> DistanciasCliente.DistanciasServer.DistanciasServer.calcularDistanciaMaximaAsync(DistanciasCliente.DistanciasServer.calcularDistanciaMaximaRequest request) {
            return base.Channel.calcularDistanciaMaximaAsync(request);
        }
        
        public System.Threading.Tasks.Task<DistanciasCliente.DistanciasServer.calcularDistanciaMaximaResponse> calcularDistanciaMaximaAsync(string arg0, int arg1) {
            DistanciasCliente.DistanciasServer.calcularDistanciaMaximaRequest inValue = new DistanciasCliente.DistanciasServer.calcularDistanciaMaximaRequest();
            inValue.arg0 = arg0;
            inValue.arg1 = arg1;
            return ((DistanciasCliente.DistanciasServer.DistanciasServer)(this)).calcularDistanciaMaximaAsync(inValue);
        }
        
        public string calcularDistanciaDuasCidades(string arg0, string arg1) {
            return base.Channel.calcularDistanciaDuasCidades(arg0, arg1);
        }
        
        public System.Threading.Tasks.Task<string> calcularDistanciaDuasCidadesAsync(string arg0, string arg1) {
            return base.Channel.calcularDistanciaDuasCidadesAsync(arg0, arg1);
        }
    }
}
